# Working with Jupyter Notebooks
## Requirements
- Python > 3.10 and pip installed on your system
- Kotlin >= 1.8.0
- JVM >= 11

Kotlin and the JVM can be installed with  the provided scripts below:
- Kotlin is installed with [https://sdkman.io](SDKMan)
- The JDK installed will be the `default-jdk`

Note:
- The command `python3 -m venv` should not raise errors. If it does:
```bash
sudo apt install python3-venv
```
For Debian/Ubuntu Distros.

## Using the Scripts
You can install kotlin only by typing:
```bash
bash <(curl -s https://raw.githubusercontent.com/S-furi/unibo-internship/main/scripts/install_kotlin_notebook.sh)
```

To download python or kotlin you can use this single script
```bash
bash <(curl -s https://raw.githubusercontent.com/S-furi/unibo-internship/main/scripts/interactive_install.sh)
```
And then you can select:
1. Python Jupyter dependencies
2. Kotlin Jupyter dependencies
3. Exit the script

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

## Post installation
### Koltin
After activating the virtual environment, you can edit and create notebooks
inside Jupyer.
Please note that the first time you run the cells with the `%use
<package_name>` this may take a while due to package resolution with Maven. It
should be faster the next times you re-run them.

You can see from the terminal output of Jupyter which operations the notebook
is doing.

#### Known kernel problems
Sometimes the kernel freezes, and when executing a cell no output is displayed.
Other times it remains in an idle state when executing a cell for too much
time. In these cases, I found out that clicking on "Kernel->Reconnect" on
Jupyter toolbar fixes the problem.
