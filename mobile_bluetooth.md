Bluetooth 
==============

- [Peripheral and central at the same time on iOS](http://stackoverflow.com/questions/17732321/peripheral-and-central-at-the-same-time-on-ios)
	- Although the same device being central and peribheral at the same time is not standard as per Bluetooth current specification, iOS currently supports it.
	- [Peripheral and central at the same time on iOS](http://stackoverflow.com/questions/17732321/peripheral-and-central-at-the-same-time-on-ios)










---

##Content before Oct.22 2014

----



Bluetooth for interaction
------------
[Continous Close-proximity RSSI-based Tracking in Wireless Sensor Networks](http://www.cs.huji.ac.il/~dolev/pubs/tracking.pdf): High accuracy tracking.



Android / iOS
-----------

|                                   |    android | ios    |
|-----------------------------------|------------|--------|
| running as a BLE peripheral       |    no      |   yes  |
| running as a BLE center           |    yes     |   yes  |


Thoughout 
-----------
- the iPhone 4S won't accept any lower Conn_Interval values than 0x0f. 
- Conn_Interval = 0x000f = 18.75 ms (Apple's hardware guideline claimed it at 20ms)
- 20 bytes * 50 hz * 8 = 8 kbit/s (disable callback)

Demo
-----------
[](https://www.youtube.com/watch?v=dMWEl6GBGqk)


RSSI
-----------



Connections
-----------
A slave(server/prepheral) may only be connected to a single master, but a master may be connected to multiple slaves. (up to 8)

The BLE protocol specification requires that the maximum data payload size for these operations is 20 bytes, or in the case of read operations, 22 bytes. BLE is built for low power consumption, for infrequent short-burst data transmissions. Sending lots of data is possible, but usually ends up being less efficient than classic Bluetooth when trying to achieve maximum throughput.

[Reconnecting process](https://developer.apple.com/library/ios/documentation/NetworkingInternetWeb/Conceptual/CoreBluetooth_concepts/Art/ReconnectingToAPeripheral_2x.png)

[Android 4.4.1 connections can be up to 8](http://www.androidpolice.com/2013/12/13/whats-really-new-in-android-4-4-2/)
>Bluetooth LE Connections
Prior to 4.4.1, the number of devices that could be simultaneously connected to an Android device topped out at four. With a commit put in before the 4.4.1 update, that limit is bumped up to seven.

Points we may need to address in the paper:
------------

1. Nearby WLAN devices were turned off during the measurements because WLANs and Bluetooth share the same frequency band [15].
2. Traditional bluetooth has two problem in locationing: adjust signal strength when signals become too strong or too weak, makeing any subsequent distance measurements based on signal strength unreliable. Takes a lot of time for new device to be fully discovered.



$$    RSSI = -(10 * n* \log_{10} D + A)$$

References
-----------
** General **

- [BLE master/slave, GATT client/server, and data RX/TX basics](https://bluegiga.zendesk.com/entries/25053373--REFERENCE-BLE-master-slave-GATT-client-server-and-data-RX-TX-basics)  (very nice article)
- [EE regarding BLE](http://stackoverflow.com/questions/10354613/bluetooth-low-energy-updating-a-characteristic-value-repeatedly)
- [Does android support to act as a peripheral](http://stackoverflow.com/questions/19717902/does-android-kitkat-allows-devices-that-support-bluetooth-le-to-act-as-a-periphe)
- [Core Bluetooth programming Guide](https://developer.apple.com/library/ios/documentation/NetworkingInternetWeb/Conceptual/CoreBluetooth_concepts/CoreBluetoothOverview/CoreBluetoothOverview.html#//apple_ref/doc/uid/TP40013257-CH2-SW1)
- [Bluetooth Low Energy: the best media for sensors and actuators?](http://www.iebmedia.com/index.php?id=8294&parentid=63&themeid=255&hft=67&showdetail=true&bb=1)
- [Can iOS do central and peripheral work on same app at same time?](http://stackoverflow.com/questions/16985891/can-ios-do-central-and-peripheral-work-on-same-app-at-same-time)
- [How to continuously get RSSI without connecting to the BLE device?](http://stackoverflow.com/questions/20058450/how-to-continuously-get-rssi-without-connecting-to-the-ble-device)
- [What are state of the art technologies for location-finding indoors, where GPS doesn’t work?](http://www.quora.com/Indoor-Positioning/What-are-state-of-the-art-technologies-for-location-finding-indoors-where-GPS-doesn%E2%80%99t-work)
- [RSSI to distance](http://blog.sina.com.cn/s/blog_68ffc7a40100ueaw.html)


** Distance calculation **

- [monitoring distance between two moving objects](http://electronics.stackexchange.com/questions/61957/monitoring-distance-between-two-moving-objects)
- [Options for short range distance determination between two objects](http://electronics.stackexchange.com/questions/33110/options-for-short-range-distance-determination-between-two-objects)
- [Using Bluetooth for Short-Term Ad Hoc Connections Between Moving
Vehicles: A Feasibility Study](http://koala.ece.rice.edu/pubs/Mur2002May5UsingBluet.pdf)
- [Fuzzy locating system](http://en.wikipedia.org/wiki/Fuzzy_locating_system)
- [How Estimote calculate the distance](https://github.com/Estimote/iOS-SDK/blob/master/DistanceDemo/DistanceDemo/ViewController/ESTViewController.m)
- [How to use Rssi value to calculate Distance](http://xuepengxu.blogspot.com/2012/06/how-to-use-rssi-value-to-calculate.html)
- [Bluetooth RSSI with a basic formula](http://www.robomotic.com/android/bluetooth-rssi/)

```
//Estimote's code snippet.
// based on observation rssi is not getting bigger then -30
// so it changes from -30 to -100 so we normalize
float distFactor = ((float)self.selectedBeacon.rssi + 30) / -70;      
float newYPos = self.dotMinPos + distFactor * self.dotRange;
self.positionDot.center = CGPointMake(self.view.bounds.size.width / 2, newYPos);
```

** RSSI **

- [Wifi-based trilateration on Android](http://rvmiller.com/2013/05/part-1-wifi-based-trilateration-on-android/)
- [Two Distance measure formulas](http://www.s2is.org/Issues/v1/n2/papers/paper14.pdf)
- [Continuous Close-Proximity RSSI-based Tracking in Wireless Sensor Networks](http://www.cs.huji.ac.il/~dolev/pubs/tracking.pdf)
- [Experiments on Local Positioning with bluetooth](http://impact.asu.edu/cse535fa07/Paper%20Presentation/local%20positioning.pdf)
- [Particle filter Explained without Equations](http://www.youtube.com/watch?v=aUkBa1zMKv4)

## Publications

- [Asynchronous Ultrasonic Trilateration for Indoor Positioning of Mobile Phones](http://arrow.dit.ie/cgi/viewcontent.cgi?article=1096&context=dmccon)

** 3D Location **

- [A Relative Positioning System for Co-located Mobile Devices](http://comp.eprints.lancs.ac.uk/1016/1/ultrasound.pdf)
- [Using the Magnetic Field for IndoorLocalisation on a Mobile Phone](http://www.academia.edu/1948824/Using_the_Magnetic_Field_for_Indoor_Localisation_on_a_Mobile_Phone)
- [GPS positioning algorithm](http://www.kowoma.de/en/gps/positioning.htm)



- - -


