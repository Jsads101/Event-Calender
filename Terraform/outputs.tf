output "server" { value = "server ip: ${openstack_networking_floatingip_v2.floating_ip.address}" }
