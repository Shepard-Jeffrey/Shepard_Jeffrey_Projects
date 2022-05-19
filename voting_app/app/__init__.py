from flask import Flask

app = Flask(__name__, template_folder="templates")

app.config["SECRET_KEY"] = '571ebf8e13ca209536c29be68d435c00'
app.config["SQLALCHEMY_DATABASE_URI"] = 'sqlite:///registration.db'

def init_db():
    db.init_app(app)
    db.app = app
    db.create_all()

# from app import views
from flask_sqlalchemy import SQLAlchemy
db=SQLAlchemy(app)
init_db()