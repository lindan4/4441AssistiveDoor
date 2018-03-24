import sqlite3

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

tableInsert(2)
