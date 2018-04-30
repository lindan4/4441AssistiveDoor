from Tkinter import * #change to tkinter on pi
import cv2
import numpy as np
import sqlite3
import time
import fileDeleteMechanism as t
import os

name="Unknown"
Id=0
userExists=True
filePath='recognizer/traningData.yml'
isChosen=False
def tableInsert(Id):
        name=22
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


def okButton():
        #print "-1"
        root.destroy()

def noButton():
        #print "0"
        global isChosen
        isChosen=False
        root.destroy()

def yesButton():
        global isChosen
        isChosen=True
        t.DeleteImformation(name,Id)
        root.destroy()
        #print "1"
        
isChosen=False
if os.path.exists(filePath):
        faceDetect=cv2.CascadeClassifier('haarcascade_frontalface_default.xml');
        cam=cv2.VideoCapture(1); #change on Pi
        rec=cv2.face.LBPHFaceRecognizer_create();
        rec.read("recognizer/traningData.yml")
        i=0
        switch=False

        t_end=time.time()+10

        font = cv2.FONT_HERSHEY_COMPLEX_SMALL
        while(time.time()<=t_end):
                cv2.namedWindow('face',cv2.WINDOW_NORMAL)
                cv2.setWindowProperty("face",cv2.WND_PROP_FULLSCREEN,cv2.WINDOW_FULLSCREEN)
                ret,img=cam.read();
                gray=cv2.cvtColor(img,cv2.COLOR_BGR2GRAY);
                faces=faceDetect.detectMultiScale(gray,1.3,5);
                cv2.putText(img, "Done scanning in: " +str(int(t_end - time.time()))+" s",(280,35),font,1.25,(0,255,0));
                for(x,y,w,h) in faces:
                        cv2.rectangle(img,(x,y),(x+w,y+h),(0,255,0),2)
                        Id,conf=rec.predict(gray[y:y+h,x:x+w])
                        #
                        #print(conf);
                        if(conf<36):    # Play around with these values because camera is shitty
                           #print(conf)
                           name=tableInsert(Id)
                           switch=True
                        else:
                            name="Unknown"
                            switch=False
                            Id=0
                        #cv2.putText(img,str(name),(x,y+h),font,3.0,(0,255,0));
                        
                cv2.imshow("face",img);
                cv2.waitKey(10)
        cam.release()
        cv2.destroyAllWindows()

        if switch==True:
                root=Tk()
                root.title("Are you sure?")
                root.geometry("450x150+0+0")
                unAuthorizedLabel= Label(root,text=str(name)+", This will destroy all your files and you won't be \nrecognized by the system. \nAre you sure?",
                                font=("arial",12,"bold")).place(x=25,y=25)

                yesButton= Button(root, text="Yes", width=25, height=2,
                        command=yesButton).place(x=2,y=100)
                noButton= Button(root, text="No", width=25, height=2,
                        command=noButton).place(x=263,y=100)
                root.mainloop();

        else:
                root=Tk()
                root.title("Unauthorized access")
                root.geometry("450x150+0+0")
                unAuthorizedLabel= Label(root,text="         You are unauthorized to make these changes!",
                         font=("arial",12,"bold")).place(x=10,y=30)

                okButton= Button(root, text="Ok", width=25, height=2,
                             command=okButton).place(x=140,y=100)
                root.mainloop();
else:
        #print("suck a dick")
        userExists=False
print(str(isChosen)+","+str(name)+","+str(Id))
