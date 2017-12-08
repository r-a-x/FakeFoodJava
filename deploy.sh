mvn clean
mvn -q package -DskipTest
rsync target/fakefood-0.0.1-SNAPSHOT.jar root@35.202.86.142:/root/food
ssh -t root@35.202.86.142 'systemctl restart foo.service'