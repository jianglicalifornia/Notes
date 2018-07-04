USRP 
=========

[USRP Hardware Driver and USRP Manual](https://files.ettus.com/manual/page_usrp_x3x0.html)


Common commands:


1. `uhd_find_devices` find connected USRP devices.
2. `uhd_usrp_probe --args addr=192.168.10.32` verify if the USRP works.
3. `sudo ./rx_samples_to_file --args="addr0=192.168.10.31" --type=float --ant=TX/RX --freq=915e6 --rate=2e6 --file="/home/kim/Desktop/rtest1.dat"`


folder: `/home/kim/uhd.20180601144807/host/build/examples`

```
ping 192.168.10.31

```