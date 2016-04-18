Latex 
==============


## Inserting figures
- [Positioning of Figures](https://www.sharelatex.com/learn/Positioning_of_Figures)
-  figure* provides a floating page-wide figure (and table* a page-wide table) which will do the necessary.
- ** placing figures inside a two-column document **
	- Method 1 (appears in the following page):
		```
		\begin{figure*}

		 \center

		  \includegraphics[width=\textwidth]{AAA.eps}

		  \caption{PRF and pulses number comparison with eigenwaveform.}

		  \label{AAA}

		\end{figure*}
		```
	- Method 2 (works for figure 1 in typical chi paper) [reference](http://www.latex-community.org/forum/viewtopic.php?f=45&t=10661#p41194):
		```
		\begin{strip}
			\centering\noindent
			\rule{0.75\linewidth}{0.5\linewidth}
			\captionof{figure}{sfsefsfese}
		\end{strip}
		```