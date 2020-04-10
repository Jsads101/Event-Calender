#!/bin/bash

#echo "cd to root directory..."
cd root
#cd /home/centos

echo "installing MariaDB..."
sudo yum install mariadb-server -y
sudo systemctl start mariadb
sudo systemctl status mariadb
sudo systemctl enable mariadb



sudo yum install git -y
touch .ssh/known_hosts
ssh-keyscan gitlab.cs.cf.ac.uk >> .ssh/known_hosts
chmod 644 .ssh/known_hosts


 cat << 'EOF' >> gitlab_hb_keypair.key
-----BEGIN RSA PRIVATE KEY-----
MIIEogIBAAKCAQEA1usWtWrqCAv44iXcu5/i7vyBdFKQ66ll7+7r80T0q50+KGrl
ZXKx10/9qKjdSC0W57o/q7K+IcGF6wGb+3VqwXocknYOKS9/2G0ytju6o6O05Mpt
Q7axsBIjpNfBJkKozsf8oU6slvEKLrv08Emlb4+X2rqRihT6Rw3hS+Z8rXsRbHb1
OYKfdlTXCetJBgrglNGc2XzNSjesKj0zjgaCir+wenqMgSkIRKeTMaXlUNDbU2Gd
k7IJYdTB05qx8jYyvGJLNDQah7zx3rE21lLMrveDtPImz7qa/Z7XXp+KAQiIfyjU
zyFxEZx5+Hvtb5kmGed1sVxqXcn4DQX6G7sKBwIDAQABAoIBAGDvIYvrz+iXNccS
Wq+JWrp9ywmjH9gazG5eba+IX25z+pASPqr2Az5gxsDmgP/Hznfv6j3P3a+t8G/h
hu/wspjXMcHhW1u6H8iG4AOPhwu9j55NquCKqzQFymvUIDrYf/jb/JbovDFMQFJ5
1ez22pYpxs0Rrwj/ky6vFPm92GgJsUPefuLYdiLB1G3OWb/EKsgwNQHAnul2nqT+
fdU5UnmS2OYBepedcsWevB28KfbCoSPCepDk19GCJ6+BuzBp5evXfoRflHAXLA2C
KtBwWVEWfDy0VukJO/KodYXnVU+Jnh0K48I0fmX40sE50+56Uhj8ynliQHU5tH9X
GhMf5okCgYEA80bpAQAwWrkbc5jXZD/gjtSELbjF0m7f9IGbV+SeXn9zR/2rNW/C
hlwvQAUl84ULNt0tVDonRnEX0qfQeeJmWIZu0qh9zyXIaUukA3r02wxoE4UGD+uL
KH7J1VfPNMrcZVtpvAkRnL+zQBgFGcjgtlbyplsc1A7KCnQxJebXDX0CgYEA4iiA
TpPUrAhj5K3TTDl3F1lwqfW8Nr6Td12NTJchqb+BoeQ9oNRySo6sDG37AZf560Af
L7YGiIM7qe6f9SpqqsvEmKtSlgpN4B51xm09uni48iWuK00d0HbgyOpJcQNuKQ7L
3UHErzR/YMeuVxLqa7tPVev8EfPWG7bsAofKXNMCgYBv1UYhdqPD4No0vqstY4vo
PNtyZUFTJjL/pGDz+52t1Sr6iisdSn4C4/e4l2VF2AA6vVwsHvuVD0IjTY+xqBji
UxI49sm24yiI9wOzsd9DnyVs67bItL/o4rgHwfD31NWSJn6puQWGqD1PlnspykU6
rSeov7O17AKG4bkCMmbjxQKBgCCoqJ6wSm3taD+FupWvVrtQdyyUB/H/41vBbr44
tOvGc/nk8+FdzINnxwCkgTLht315bQd+ycK88MjBZOgKkAzKEEHbu7lfE4/h1jAp
ZlifRlXxiw1FvaB1ClD5RFHFpQrY0CfLb5O9iQd4znxUhvW3vuUxht0w0SJ/b+WN
pnNxAoGAeS8WTyEsW+sZ0pLs+qy1Rodb0WSex4QxclOGMfFeyK3EMCbmGE/qwi2Q
VqQz+6q8wlrRPoR2Ctxs2jfzjU8neOTB48/Qu8kLjcFO5rraI95zS09P2hcHkUT0
tDpM+Xe8kp8C65Oz+EHuOt9KPgcujHqSLG+F5nt8WSEjndF8Zns=
-----END RSA PRIVATE KEY-----
EOF
chmod 400 gitlab_hb_keypair.key
ssh-agent bash -c 'ssh-add gitlab_hb_keypair.key; git clone -b master git@gitlab.cs.cf.ac.uk:c1981660/hodgebank.git'

cd hodgebank/
mysql -u root < hodge.sql

curl -O https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_linux-x64_bin.tar.gz
tar zxvf openjdk-11.0.2_linux-x64_bin.tar.gz
sudo mv jdk-11.0.2 /usr/local/
export JAVA_HOME=/usr/local/jdk-11.0.2
export PATH=$PATH:$JAVA_HOME/bin
sudo yum install wget -y
wget https://services.gradle.org/distributions/gradle-5.4.1-bin.zip

sudo yum install unzip -y
sudo mkdir /opt/gradle

sudo unzip -d /opt/gradle gradle-5.4.1-bin.zip
export PATH=$PATH:/opt/gradle/gradle-5.4.1/bin
mysql -u root -e "USE mysql; UPDATE user SET password=PASSWORD('comsc') WHERE User = 'root' AND Host = 'localhost'; FLUSH PRIVILEGES;"

gradle build
gradle bootrun
