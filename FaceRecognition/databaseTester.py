import sqlite3

def tableInsert(serialID, name):
        conn=sqlite3.connect('FaceBase.db')
        print "connected successfully"
##        conn.execute("insert into People (SerialNumber, Name) values (?, ?)",
##                     (serialID,name))
        conn.execute("Delete from People")
        conn.commit()
        conn.close()
            
tableInsert(12, "saad")
