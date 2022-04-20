FROM adoptopenjdk/openjdk11 as builder

WORKDIR /app
COPY . /app

RUN ./gradlew linkReleaseExecutable

FROM debian:stable-slim

COPY --from=builder /app/build/bin/linuxX64/releaseExecutable/ktorrestapi.kexe /ktorrestapi.kexe

ENTRYPOINT ["/ktorrestapi.kexe"]