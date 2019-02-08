FROM develar/java:8u45
VOLUME /tmp
ADD startup.sh /
ADD *.jar /
RUN sh -c 'chmod +x /startup.sh'
ENTRYPOINT ["/startup.sh"]