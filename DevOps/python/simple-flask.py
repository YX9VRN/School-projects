from flask import Flask
import requests

app = Flask(__name__)

@app.route("/<digits>", methods = ["GET"])
def specified_number(digits):
    url = "http://numbersapi.com/"+digits
    response = requests.get(url)
    return response.text

@app.route("/epsteindidntkillhimself", methods = ["GET"])
def default():
	url = "https://numbersapi.com/random"
	response = requests.get(url)
	return response.text

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=80)
