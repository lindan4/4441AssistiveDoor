import cv2
import numpy as np
import sqlite3

faceDetect=cv2.CascadeClassifier('haarcascade_frontalface_default.xml');
cam=cv2.VideoCapture(1);
rec=cv2.face.LBPHFaceRecognizer_create();
rec.read("recognizer\\traningData.yml")

def tableInsert(Id):
        name=22
        conn=sqlite3.connect('FaceBase.db')
        print "connected successfully"
        cur=conn.execute("Select Name from People where SerialNumber = ?", [int(Id)])
        conn.commit()

        #cur=conn.cursor()
        
        row=cur.fetchone()

        for r in row:
            name=r
            
        print(str(name))
        conn.close()
        return name


font = cv2.FONT_HERSHEY_COMPLEX_SMALL
while(True):
    ret,img=cam.read();
    gray=cv2.cvtColor(img,cv2.COLOR_BGR2GRAY);
    faces=faceDetect.detectMultiScale(gray,1.3,5);
    for(x,y,w,h) in faces:
        cv2.rectangle(img,(x,y),(x+w,y+h),(0,255,0),2)
        Id,conf=rec.predict(gray[y:y+h,x:x+w])
        print(conf);
        if(conf<42):    # Play around with these values because camera is shitty
           print("confidence below 42")
           name=tableInsert(Id)
        else:
            name="Unknown"
        cv2.putText(img,str(name),(x,y+h),font,3.0,(0,255,0));
        
    cv2.imshow("face",img);
    if(cv2.waitKey(1)==ord('q')):
        break;
cam.release()
cv2.destroyAllWindows()

