Signal processing
===========
[gimmick: math]()


##Kalman filter

Best tutorials:  [A practical approach to Kalman filter and how to implement it](), [An Engineer's perspective](http://biosport.ucdavis.edu/lab-meetings/KalmanFilterPresentation)
[Matlab implementation](http://www.mathworks.com/help/control/ug/kalman-filtering.html)

Best tutorial code: [Kalman filter in python](https://github.com/dougszumski/KalmanFilter)

** Steps to work on a Kalman filter problem **

1. Define the state model, input-control model.
2. Define the transition model and observer model.
3. Recursive processing pipeline:
	- making a prediction of the future
	- getting a measurement from reality
	- comparing the two 
	- moderating this difference
	- adjusting its estimate with this moderated value.


###Sensor fusion with Kalman filter
** indirect feedback kalman filter (error-state Kalman ﬁlter) **: 

In such a conﬁguration, the Kalman ﬁlter is used to estimate the difference between the current inertial and optical (or acoustic) outputs, i.e. it continually estimates the error in the inertial estimates by using the optical system as a second (redundant) reference. 

This error estimate is then used to correct the inertial estimates. The tuning of the Kalman ﬁlter parameters (see “Parameter Estimation or Tuning” on page 35) then adjusts the weight of the correction as a function of frequency. [Reference](http://www.cs.unc.edu/~tracker/media/pdf/SIGGRAPH2001_CoursePack_08.pdf)

Related work:
[Sensor Fusion & Kalman Filter 1](http://www.slideshare.net/antoniomorancardenas/data-fusion-with-kalman-filtering-21838422)
[Sensor Fusion & Kalman Filter 2](http://campar.in.tum.de/Chair/KalmanFilter)
 
 

###Example

For normal mobile phones, we have two sets of sensors: accelerometers and position sensors (like GPS, RSSI). Using the Kalman Filter can fust the sensor data and estimate the position.

** System definition **

$$ p_{t+1} = p_t + v_t \cdot {\Delta t} + \frac{1}{2} \cdot a_t \cdot {\Delta t}^2 $$

$$ v_{t+1} = v_t + a_t \cdot {\Delta t} $$


** State vector at time k is **:

$$ s_k = [p_x, p_y, p_z, v_x, v_y, v_z]^T $$

** Input-control model **:

$$ u_k = [a_x, a_y, a_z]^T $$ 

** Transition model **:

$$s_{k+1} = A \cdot s_k + B \cdot {u_k} + w_k$$


$$$ w_k $$$ is process noise which is Gaussian distributed with a zero mean and with covariance Q to the time k:
$$ w_k \sim N(0, Q_k) $$

** Observation/Measurement model **

$$z_k = H \cdot s_k + v_k $$


$$$ v_k $$$ is measurement noise which is Gaussian distributed with a zero mean and with covariance Q to the time k:
$$ v_k \sim N(0, R_k) $$


#### Details:

$$ A = 
\begin{bmatrix}
1 & 0 & 0 & {\Delta t} & 0 & 0\\\
0 & 1 & 0 & 0 & {\Delta t} & 0\\\
0 & 0 & 1 & 0 & 0 & {\Delta t}\\\
0 & 0 & 0 & 1 & 0 & 0\\\
0 & 0 & 0 & 0 & 1 & 0\\\
0 & 0 & 0 & 0 & 0 & 1\\\
\end{bmatrix}
$$


$$ B = 
\begin{bmatrix}
\frac{1}{2}{\Delta t}^2  & 0 & 0\\\
0 & \frac{1}{2}{\Delta t}^2  & 0\\\
0 & 0  & \frac{1}{2}{\Delta t}^2\\\
1 & 0 & 0\\\
0 & 1 & 0\\\
0 & 0 & 1\\\
\end{bmatrix}
$$

Measurement covariance matrix:
$$ R = 
\begin{bmatrix}
{\sigma_x}^2  & 0 & 0\\\
0 & {\sigma_y}^2  & 0\\\
0 & 0 & {\sigma_z}^2 \\\
\end{bmatrix}
$$

$$${\sigma_x}$$$ is simply the standard deviation of the sensor squared or the variance of the sensor. Here the sensor is the location sensor like GPS.

Process covariance matrix:

$$ R_v = E[(v_i - \overline{v})(v_i- \overline{v})] =
\begin{bmatrix}
{\sigma_x}^2 & 0 & 0\\\
0 & {\sigma_y}^2  & 0\\\
0 & 0 & {\sigma_z}^2 \\\
\end{bmatrix}
$$

$$ F = \frac {\delta s} {\delta v} = B
$$


$$ Q = F \cdot R_v \cdot F^T = B \cdot R_v \cdot B^T 
= \begin{bmatrix}
\frac{1}{2}{\Delta t}^2  & 0 & 0\\\
0 & \frac{1}{2}{\Delta t}^2  & 0\\\
0 & 0  & \frac{1}{2}{\Delta t}^2\\\
1 & 0 & 0\\\
0 & 1 & 0\\\
0 & 0 & 1\\\
\end{bmatrix} \cdot 
\begin{bmatrix}
{\sigma_x}^2 & 0 & 0\\\
0 & {\sigma_y}^2  & 0\\\
0 & 0 & {\sigma_z}^2 \\\
\end{bmatrix} \cdot \begin{bmatrix}
\frac{1}{2}{\Delta t}^2 & 0 & 0 & 1 & 0 & 0 \\\
0 & \frac{1}{2}{\Delta t}^2 & 0 & 0 & 1 & 0 \\\
0 & 0 & \frac{1}{2}{\Delta t}^2  & 0 & 0 & 1 \\\
\end{bmatrix}
$$

$$${\sigma_x}$$$ is $$${\sigma_{accx}}$$$ exactly. The standard derivation of accelermeters.

$$ H = 
\begin{bmatrix}
1 & 0 & 0\\\
0 & 1  & 0\\\
0 & 0  & 1\\\
0 & 0 & 0\\\
0 & 0 & 0\\\
0 & 0 & 0\\\
\end{bmatrix}
$$


[wolframalpha calculation result](http://www.wolframalpha.com/input/?i=%7B%7Bt%5E2%2F2%2C+0%2C+0%7D%2C+%7B0%2C+t%5E2%2F2%2C+0%7D%2C+%7B0%2C+0%2C+t%5E2%2F2%7D%2C+%7B1%2C+0%2C+0%7D%2C+%7B0%2C+1%2C+0%7D%2C+%7B0%2C+0%2C+1%7D%7D+.+%7B%7Bx%5E2%2C+0%2C+0%7D%2C+%7B0%2C+y%5E2%2C+0%7D%2C+%7B0%2C+0%2C+z%5E2%7D%7D+.+%7B%7Bt%5E2%2F2%2C+0%2C+0%2C+1%2C+0%2C+0%7D%2C+%7B0%2C+t%5E2%2F2%2C+0%2C+0%2C+1%2C+0%7D%2C+%7B0%2C+0%2C+t%5E2%2F2%2C+0%2C+0%2C+1%7D%7D)


[wolframalpha example for 2d](http://www.wolframalpha.com/input/?i=%7B%7Bt%5E2%2F2%2C+0%7D%2C+%7Bt%2C+0%7D%2C+%7B0%2C+t%5E2%2F2%7D%2C+%7B0%2C+t%7D%7D.%7B%7Bx%5E2%2C0%7D%2C+%7B0%2C+y%5E2%7D%7D.%7B%7Bt%5E2%2F2%2C+t%2C+0%2C+0%7D%2C%7B0%2C0%2C+t%5E2%2F2%2C+t%7D%7D)

#### Implementations:



** References **

- [Kalman Filters for undergrads](http://greg.czerniak.info/guides/kalman1/)
- [A 3D State Space Formulation of a Navigation Kalman Filter for Autonomous Vehicles](http://www.frc.ri.cmu.edu/~alonzo/pubs/reports/kalman_V2.pdf)
- [Robotutils](https://github.com/psigen/robotutils)
- [the must read page for kalman filter](http://www.cs.unc.edu/~welch/kalman/) 
- [Nice tutorial for applications](http://blog.tkjelectronics.dk/2012/09/a-practical-approach-to-kalman-filter-and-how-to-implement-it/)
- [Video tutorial for Kalman filter](http://studentdavestutorials.weebly.com/kalman-filter-with-matlab-code.html)

###multiple rates kalman filter

- [Multi-sensor fusion in Kalman Filter with different data rates](http://www.rcgroups.com/forums/showthread.php?t=1215585)




## Match filter

###Peak detection in a time-series data

- [matlab implementation](http://billauer.co.il/peakdet.html)
- [c implementation](https://github.com/xuphys/peakdetect)
- [Simple Algorithms for Peak Detection in Time-Series](http://www.tcs-trddc.com/trddc_website/pdf/SRL/Palshikar_SAPDTS_2009.pdf)
