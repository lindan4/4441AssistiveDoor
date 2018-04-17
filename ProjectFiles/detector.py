import cv2
import time 
import numpy as np
import sqlite3
from Tkinter import *

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
            
        #print(str(name))
        conn.close()
        return name


faceDetect=cv2.CascadeClassifier('haarcascade_frontalface_default.xml');
cam=cv2.VideoCapture(1);
rec=cv2.face.LBPHFaceRecognizer_create();
rec.read("recognizer\\traningData.yml")
font = cv2.FONT_HERSHEY_COMPLEX_SMALL
t_end=time.time()+10
name="Unknown"

sentinel=False
Id=0
#root = Tk()

### timer
##lbl1 = Label()
##lbl1.pack(fill=BOTH, expand=1)
##root.geometry("250x100+800+100")
##lbl1.config(height=3, font=('times', 20, 'bold'))

while time.time()<=t_end:
        cv2.namedWindow('image',cv2.WINDOW_NORMAL)
        cv2.setWindowProperty("image",cv2.WND_PROP_FULLSCREEN,cv2.WINDOW_FULLSCREEN)
       ## cv2.moveWindow("image", 0,0);
        #cv2.resizeWindow('image', 480,320)
        #cv2.setWindowProperty("image",WND_PROP_FULLSCREEN,WINDOW_FULLSCREEN);        
        ret,img=cam.read();
        gray=cv2.cvtColor(img,cv2.COLOR_BGR2GRAY);
        faces=faceDetect.detectMultiScale(gray,1.3,5);
        for(x,y,w,h) in faces:
                cv2.rectangle(img,(x,y),(x+w,y+h),(0,255,0),2)
                Id,conf=rec.predict(gray[y:y+h,x:x+w])
                #print(conf);
                if(conf<48):    # Play around with these values because camera is shitty
                #print("confidence below 42")
                        name=tableInsert(Id)
                else:
                        name="Unknown"
                #cv2.putText(img,str(name),(x,y+h),font,3.0,(0,255,0));
                
        cv2.putText(img, "Done scanning in: " +str(int(t_end - time.time()))+" s",(280,35),font,1.25,(0,255,0));
        cv2.imshow("image",img);
        cv2.waitKey(1)
        #lbl1["text"] ="Done scanning in: "+ str(int(t_end - time.time()))
        #root.update()
             #   break;
cam.release()
cv2.destroyAllWindows()
##root.destroy()
##root.mainloop()

if name=="Unknown":
        #print "You are unauthorized to enter!"
        sentinel=False
        Id=0
else:
        #print "We found a match as " +name+". You may proceed to the next phase"
        sentinel=True
print str(sentinel)+ "," +name +"," +str(Id)
