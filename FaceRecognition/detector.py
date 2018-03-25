import cv2
import time 
import numpy as np
import sqlite3


def tableInsert(Id):
        name=0
        conn=sqlite3.connect('FaceBase.db')
        #print "connected successfully"
        cur=conn.execute("Select Name from People where SerialNumber = ?", [int(Id)])
        conn.commit()

        #cur=conn.cursor()
        
        row=cur.fetchone()

        for r in row:
            name=r
            
        print(str(name))
        conn.close()
        return name

def faceDetector():
        faceDetect=cv2.CascadeClassifier('haarcascade_frontalface_default.xml');
        cam=cv2.VideoCapture(1);
        rec=cv2.face.LBPHFaceRecognizer_create();
        rec.read("recognizer\\traningData.yml")
        font = cv2.FONT_HERSHEY_COMPLEX_SMALL
        t_end=time.time()+5
        name="Unknown"

        sentinel=False
        
        while time.time()<=t_end:
            ret,img=cam.read();
            gray=cv2.cvtColor(img,cv2.COLOR_BGR2GRAY);
            faces=faceDetect.detectMultiScale(gray,1.3,5);
            for(x,y,w,h) in faces:
                cv2.rectangle(img,(x,y),(x+w,y+h),(0,255,0),2)
                Id,conf=rec.predict(gray[y:y+h,x:x+w])
                print(conf);
                if(conf<42):    # Play around with these values because camera is shitty
                   #print("confidence below 42")
                   name=tableInsert(Id)
                else:
                    name="Unknown"
                cv2.putText(img,str(name),(x,y+h),font,3.0,(0,255,0));
                
            cv2.imshow("face",img);
            cv2.waitKey(1)
             #   break;
        cam.release()
        cv2.destroyAllWindows()

        if name=="Unknown":
                print "You are unauthorized to enter!"
        else:
                print "We found a match as " +name+". You may proceed to the next phase"
                sentinel=True
        return sentinel
