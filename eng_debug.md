GDB commands
===========

## remote debugging for code coverage

- mount the remote directory to a local directory: 
	- `sshfs username@domain:remote_directory local_directory`
	- enter that directory through "go to folder"
	- recommend to install sshfs through `brew install`
	- `umount local_directory` after usage.
	
## Java code coverage

- clover


## multithread debugging:

- Display a summary of all threads currently in your program: `info threads`
- Make thread number threadno the current thread: `thread threadno` `thread 2`


## Output arrays:

- Print arrays:  `p (float[1080])*preamble_signal `
