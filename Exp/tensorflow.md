#tensorflow 

###error:
No module named protobuf
###how:
first, uninstall protobuf: pip uninstall protobuf
then, install tensorflow again

###error:
libcudart.so.7.5: cannot open shared object file: No such file or directory
###how:
vim bashrc, add: export LD_LIBRARY_PATH="$LD_LIBRARY_PATH:/usr/local/cuda/lib64

###change:
tf.initialize_all_variables() 

tf.global_variables_initializer()

###error:
raise RuntimeError('Invalid DISPLAY variable')
RuntimeError: Invalid DISPLAY variable
###how:
You must declare matplotlib.use('Agg') before import pylab as plt.
import matplotlib
matplotlib.use(‘Agg’)