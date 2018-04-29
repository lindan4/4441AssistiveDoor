import os
import cv2
import numpy as np
import sqlite3
from PIL import Image

def getImagesWithID(path):
        imagePaths=[os.path.join(path,f) for f in os.listdir(path)]
        faces=[]
        IDs=[]
        for imagePath in imagePaths:
            faceImg=Image.open(imagePath).convert('L');
            faceNp=np.array(faceImg,'uint8')
            ID= int(os.path.split(imagePath)[-1].split(".")[1])
            faces.append(faceNp)
            IDs.append(ID)
#            cv2.imshow("training",faceNp)
            cv2.waitKey(10)
        return np.array(IDs),faces


recognizer=cv2.face.LBPHFaceRecognizer_create();
path='facesData'
deleteTrainer='recognizer/traningData.yml'

def trainingMechanism():
        users=0;
        conn=sqlite3.connect('FaceBase.db')
        #print ("connected successfully")
        
        cur=conn.execute("select count(*) from People ")
        conn.commit()
        

        row=cur.fetchone();
        for r in row:
                users=r
                print(users)

        
        conn.close()

        if users<1:
                print("Less than 1")
                print("suck me"
                os.remove(deleteTrainer)
                
        else:
                print("greater than 1")
                Ids,faces=getImagesWithID(path)
                recognizer.train(faces,Ids)
                recognizer.save('recognizer/traningData.yml')
                cv2.destroyAllWindows()
                print("Done training")
#trainingMechanism()
