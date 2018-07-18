USRP 
=========

[USRP Hardware Driver and USRP Manual](https://files.ettus.com/manual/page_usrp_x3x0.html)


Common commands:


1. `uhd_find_devices` find connected USRP devices.
2. `uhd_usrp_probe --args addr=192.168.10.32` verify if the USRP works.
3. `sudo ./rx_samples_to_file --args="addr0=192.168.10.31" --type=float --ant=TX/RX --freq=2450e6 --rate=1e5 --file="/home/kim/Desktop/t_1min_1e5.dat" --duration 60`
4. `sudo ./rx_multi_samples --args="addr0=192.168.10.31" --subdev "A:0 B:0" --channels "0,1"`


folder: `/home/kim/uhd.20180601144807/host/build/examples`

```
ping 192.168.10.31

```

Dev: 

1. `cd ~/uhd/host/build; cmake ..` to compile the cpp files into executables
2. Executables would be at `~/uhd/host/build/examples`
3. THe source files are at `~/uhd/host/examples`
4. [complete guide](https://kb.ettus.com/Getting_Started_with_UHD_and_C%2B%2B)


`scp kim@128.237.216.182:~/Desktop/rtest1.dat .`


`matlab -softwareopengl`


 plot(abs(x_1))
K>> plot(abs(fftshift(fft(x_1))))
K>> spectrogram(x_1,128,64,[],10,'yaxis","center")
 spectrogram(x_1,128,64,[],10,'yaxis","center")
                              ↑
Error: Character vector is not terminated properly.
 
K>> spectrogram(x_1,128,64,[],10,'y-axis","center")
 spectrogram(x_1,128,64,[],10,'y-axis","center")
                              ↑
Error: Character vector is not terminated properly.
 
K>> spectrogram(x_1)
K>> 
