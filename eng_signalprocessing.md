Signal processing
===========
[gimmick: math]()



##Kalman filter

Recursive Processing pipeline:

- making a prediction of the future
- getting a measurement from reality
- comparing the two 
- moderating this difference
- adjusting its estimate with this moderated value.

** State Model **:

State vector at time k is:
$$ s_k = [p_x, p_y, p_z, v_x, v_y, v_z, a_x, a_y, a_z]^T $$

State estimation is:

$$ s_{k+1} = A * s_k + w_k $$

** Motion Model **




##Peak detection in a time-series data

- [matlab implementation](http://billauer.co.il/peakdet.html)
- [c implementation](https://github.com/xuphys/peakdetect)
- [Simple Algorithms for Peak Detection in Time-Series](http://www.tcs-trddc.com/trddc_website/pdf/SRL/Palshikar_SAPDTS_2009.pdf)

##References

- [Kalman Filters for undergrads](http://greg.czerniak.info/guides/kalman1/)
- [A 3D State Space Formulation of a Navigation Kalman Filter for Autonomous Vehicles](http://www.frc.ri.cmu.edu/~alonzo/pubs/reports/kalman_V2.pdf)
- [Robotutils](https://github.com/psigen/robotutils)
- [the must read page for kalman filter](http://www.cs.unc.edu/~welch/kalman/) 
