from Tkinter import *
import sqlite3
import cv2
import time
import numpy as np
import os.path

root = Tk()

def destroyAll():
    root.destroy()

path="sRF.txt"


faceDetect=cv2.CascadeClassifier('haarcascade_frontalface_default.xml');

def creationMechanism():
        f=0
        g=0
        h=0
        
        #GUI
        root.title("Information required")
        root.geometry("450x150+500+400") #Works for the Surface Screen

        infoPrompt=Label(root,text="Please enter your name:",
                         font=("arial",12,"bold")).place(x=10,y=30)

        name=StringVar() #user name stored here
        entry_box = Entry(root, textvariable=name, width=35).place(x=220,y=33)

        okButton= Button(root, text="Ok", width=25, height=2,
                         command=destroyAll).place(x=140,y=100)

        root.mainloop();

        sampleNum=0;
        #id=raw_input('Please enter your name: ')

        #Frontal face capture
        serialID=0
        if len(name.get()) == 0:
            print("Cant leave name field empty")
            return False
        else:
            cam=cv2.VideoCapture(1);

            if os.path.isfile(path):
                print("File exists")
                g=open(path,"r")
                serialID=int(g.read())
                serialID=serialID+1
                g.close()
            else:
                print("File does not exist. Create one fam")
                f=open(path,"w+")
                serialID=serialID+1
                f.close();
                
            print "Taking a picture for training purposes"

            while(True):
                
                ret,img=cam.read();
                gray=cv2.cvtColor(img,cv2.COLOR_BGR2GRAY);
                faces=faceDetect.detectMultiScale(gray,1.3,5);
                for(x,y,w,h) in faces:
                    sampleNum=sampleNum+1;
                    cv2.imwrite("facesData/"+str(name.get())+"."+ str(serialID)+"." +str(sampleNum)+ ".jpg", gray[y:y+h, x:x+w])
                    cv2.rectangle(img,(x,y),(x+w,y+h),(0,255,0),2)
                    cv2.waitKey(100);
                cv2.imshow("face",img);
                cv2.waitKey(1)
                if(sampleNum>100):
                    break
                
            cam.release()
            cv2.destroyAllWindows()
            h=open(path,"w")
            h.write(str(serialID))
            h.close()
            tableInsert(serialID, str(name.get()))
            return True

def tableInsert(serialID, name):
        conn=sqlite3.connect('FaceBase.db')
        print "connected successfully"
        conn.execute("insert into People (SerialNumber, Name) values (?, ?)",
                     (serialID,name))
        conn.commit()
        conn.close()
