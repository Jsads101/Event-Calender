variable "flavor" { default = "m1.medium" }
variable "image" { default = "CentOS 7 20200205" }
#variable "instance" { default = "tf_instance" }

variable "name" { default = "server" }

variable "network" { default = "c1981660_network2" }   # you need to change this
variable "keypair" { default = "mykey" }       # you need to change this

variable "pool" { default = "cscloud_private_floating" }
variable "server_script" { default = "./server.sh" }
variable "security_description" { default = "Terraform security group" }
variable "security_name" { default = "tf_security_three" }
