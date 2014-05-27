Signal processing
===========
[gimmick: math]()


##Kalman filter

** Steps to work on a Kalman filter problem **

1. Define the state model, input-control model.
2. Define the transition model and observer model.
3. Recursive processing pipeline:
	- making a prediction of the future
	- getting a measurement from reality
	- comparing the two 
	- moderating this difference
	- adjusting its estimate with this moderated value.


** Traditional case **:

For the realworld system, the car usually has a power system which generate a power and motivate the cars. The acceleration is known: $$ a = F/m $$


** State vector at time k is **:

$$ s_k = [p_x, p_y, p_z, v_x, v_y, v_z]^T $$

** Input-control model **:

$$ u_k = [a_x, a_y]^T $$

** Transition model **:

$$ v_{t+1} = v_t + a_t * {\Delta t} $$


$$ s_{k+1} = A * s_k + B * {u_k} + w_k $$

$$ p_{t+1} = p_t + v_t * {\Delta t} + \frac{1}{2} * a_t * {\Delta t}^2 $$

$$ v_{t+1} = v_t + a_t * {\Delta t} $$

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



** Tracko ** 







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