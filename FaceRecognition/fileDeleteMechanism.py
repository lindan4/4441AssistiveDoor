import glob
import os
import sqlite3
import trainer as t

def DeleteImformation(names,Id):
    for name in glob.glob('facesData/'+names+'.'+str(Id)+'.*.jpg'):
#        print name
        os.remove(name)
    print("files have been deleted");
    
    conn=sqlite3.connect("faceBase.db")
    conn.execute("Delete from People where SerialNumber= ? and Name= ?"
                 ,(Id,names))
    
    conn.commit()
    print("Database traces have been deleted");
    t.trainingMechanism()


