import os
import cv2
import numpy as np
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

def trainingMechanism():
        Ids,faces=getImagesWithID(path)
        recognizer.train(faces,Ids)
        recognizer.save('recognizer/traningData.yml')
        cv2.destroyAllWindows()
        #print("Done training")
