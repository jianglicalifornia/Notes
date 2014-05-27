Signal processing
===========
[gimmick: math]()


##Kalman filter

Best tutorials:  [A practical approach to Kalman filter and how to implement it](), [An Engineer's perspective](http://biosport.ucdavis.edu/lab-meetings/KalmanFilterPresentation)

** Steps to work on a Kalman filter problem **

1. Define the state model, input-control model.
2. Define the transition model and observer model.
3. Recursive processing pipeline:
	- making a prediction of the future
	- getting a measurement from reality
	- comparing the two 
	- moderating this difference
	- adjusting its estimate with this moderated value.


##Sensor fusion with Kalman filter
** indirect feedback kalman filter (error-state Kalman ﬁlter) **: 

In such a conﬁguration, the Kalman ﬁlter is used to estimate the difference between the current inertial and optical (or acoustic) outputs, i.e. it continually estimates the error in the inertial estimates by using the optical system as a second (redundant) reference. 

This error estimate is then used to correct the inertial estimates. The tuning of the Kalman ﬁlter parameters (see “Parameter Estimation or Tuning” on page 35) then adjusts the weight of the correction as a function of frequency. [Reference](http://www.cs.unc.edu/~tracker/media/pdf/SIGGRAPH2001_CoursePack_08.pdf)

Related work:
[Sensor Fusion & Kalman Filter 1](http://www.slideshare.net/antoniomorancardenas/data-fusion-with-kalman-filtering-21838422)
[Sensor Fusion & Kalman Filter 2](http://campar.in.tum.de/Chair/KalmanFilter)
 
 

## Example:

For normal mobile phones, we have two sets of sensors: accelerometers and position sensors (like GPS). Using the Kalman Filter can fust the sensor data and estimate the position.

** System definition **

$$ p_{t+1} = p_t + v_t \cdot {\Delta t} + \frac{1}{2} \cdot a_t \cdot {\Delta t}^2 $$

$$ v_{t+1} = v_t + a_t \cdot {\Delta t} $$


** State vector at time k is **:

$$ s_k = [p_x, p_y, p_z, v_x, v_y, v_z]^T $$

** Input-control model **:

$$ u_k = [a_x, a_y]^T $$ 

** Transition model **:

$$s_{k+1} = A \cdot s_k + B \cdot {u_k} + w_k$$



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
\frac{1}{2}{\Delta t}^2  & 0\\\
0 & \frac{1}{2}{\Delta t}^2\\\
1 & 0\\\
0 & 1\\\
\end{bmatrix}
$$





##Peak detection in a time-series data

- [matlab implementation](http://billauer.co.il/peakdet.html)
- [c implementation](https://github.com/xuphys/peakdetect)
- [Simple Algorithms for Peak Detection in Time-Series](http://www.tcs-trddc.com/trddc_website/pdf/SRL/Palshikar_SAPDTS_2009.pdf)

##References

- [Kalman Filters for undergrads](http://greg.czerniak.info/guides/kalman1/)
- [A 3D State Space Formulation of a Navigation Kalman Filter for Autonomous Vehicles](http://www.frc.ri.cmu.edu/~alonzo/pubs/reports/kalman_V2.pdf)
- [Robotutils](https://github.com/psigen/robotutils)
- [the must read page for kalman filter](http://www.cs.unc.edu/~welch/kalman/) 
- [Nice tutorial for applications](http://blog.tkjelectronics.dk/2012/09/a-practical-approach-to-kalman-filter-and-how-to-implement-it/)
- [Video tutorial for Kalman filter](http://studentdavestutorials.weebly.com/kalman-filter-with-matlab-code.html)