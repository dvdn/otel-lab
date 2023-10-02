from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route("/")
def hello_world():
    print(request.args.get("param"))
    return "<p>Hello, World!</p>"