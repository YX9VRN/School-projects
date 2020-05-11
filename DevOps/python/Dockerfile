FROM python:3-onbuild
COPY . /app
WORKDIR /app
RUN pip install -r requirements.txt
ENTRYPOINT ["python"]
EXPOSE 80
CMD ["simple-flask.py"]

