FROM ubuntu:latest
LABEL authors="sanva"

ENTRYPOINT ["top", "-b"]