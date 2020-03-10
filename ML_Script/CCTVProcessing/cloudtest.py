import pyrebase
import time

config = {
    "apiKey": "oS2ePY7XoMNXyLDVYqQ56RjlIIWQ6IbzTG8tVbov",
    "authDomain": "smart-park-9f117.firebaseapp.com",
    "databaseURL": "https://smart-park-9f117.firebaseio.com",
    "storageBucket": "smart-park-9f117.appspot.com"
}

firebase = pyrebase.initialize_app(config)

db = firebase.database()

for x in range(100):
    time.sleep(3)

    if(x % 2 != 0):
        db.child("SJT").child("Block1").update({"State": "Yes"})
    else:
        db.child("SJT").child("Block1").update({"State": "No"})

    print(x)
data = db.get()
