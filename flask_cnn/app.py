from flask import Flask, render_template, request
from tensorflow.keras.preprocessing.image import img_to_array
from tensorflow.keras.models import load_model
import PIL.Image
import cv2 as cv
import numpy as np

app = Flask(__name__)
model = load_model('bicaraku.h5')

@app.route('/', methods=['GET'])
def hello_world():
    return render_template('index.html')

@app.route('/', methods=['POST'])
def predict():
    imagefile = request.files['imagefile']
    image_path = "./images/" + imagefile.filename
    imagefile.save(image_path)

    image = PIL.Image.open("images/" + imagefile.filename)
    image = image.resize((50, 50))
    gray_image = image.convert('L')

    gray_image = np.array(gray_image).flatten()
    gray_image = gray_image / 255.0
    gray_image = gray_image.reshape(-1, 50, 50, 1)

    proba = model.predict(gray_image)
    print(proba)
    proba = np.argmax(proba, axis=1)

    list_alphabet = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q',
    'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']

    for i in range(0, 27):
        if proba == i:
            alphabet = list_alphabet[i]
    
    return render_template('index.html', prediction=alphabet)

if __name__ == '__main__':
    app.run(debug=True)

    