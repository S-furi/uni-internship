# Working with Jupyter Notebooks

## Requirements
- Python > 3.10 and pip installed on your system
- Kotlin >= 1.8.0

## Python Virtual Environment
It's recommended the use of **Python Virtualenv** for handling
the different dependencies between kotlin and python notebooks.

For creating a virtual environment, it's possible to get
`virtualenv` on Linux and MacOS, otherwise you can use
the command `python3 -m venv <folder_name>`.

Now it's possibile to type
```bash
source <folder_name>/bin/activate
```
for activating python virtual environment.

Note: It's recommended to add a .gitignore (`virtualenv` should
automatically add one) for ignoring Python Virtual Environment
folder.

Now it's possible to use python in the virtual environment and 
install packages through `pip` or `pip3`. 

### Python
The following packages should be installed:
- Jupyter
- pandas
- NumPy
- MatplotLib
- Xarray

You can get them with:
```bash
pip install jupyter pandas numpy matplotlib xarray
```

### Kotlin
#### KT-Requirements
Kotlin needs kotlin to be installed and a JVM on the system.

In linux distros, the default JDK works fine 
(tested on debian 11, Asahi Linux installed with 
`sudo apt install default-jdk`).

It's possible to get kotlin easilty thanks to SDKMan,
and it can be downloaded as follows:

```bash
curl -s "https://get.sdkman.io" | bash
```

A complete reboot of the system will make sure SDKMan is 
properly installed.

Now SDKMan can be used for:
```bash
sdk install kotlin
```

and now Kotlin is installed on your system.

#### Kotlin Notebook
Now, make sure the Python virtual environment is running 
(`source <folder_name/bin/activate>`), and you are ready
to install the Jupyter Kernel for Kotlin

```bash
pip install jupyter kotlin-jupyter-kernel
```

Now it's possiible to type `jupyter notebook` and a 
window on the default browser will open on the current
folder, and a new notebook can be opened with the 
kotlin kernel.
