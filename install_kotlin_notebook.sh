#!/bin/bash

# JVM check
if type -p java > /dev/null; then
    echo "JVM already installed".
else
    read -p "Java not found on the system. Would you like to try to install default-jdk? (y/n): " java_choice
    if [ "$java_choice" = "y"]; then
        os_type=$(uname -s)
        if [$os_type == "Linux"]; then
            # hoping for apt as package manager...
            sudo apt-get update
            sudo apt-get install default-jdk -y
        elif [ $os_type == "Darwin"] ; then
            brew install openjdk
        else
            echo "Cannot install JVM automatically on this OS. \
                Please, install JDK manually and retry."
            exit 1
        fi
    else
        "Please install Java manually and then retry the installation."
        exit 0;
    fi
    echo "*** Java succesfully installed! ***"
fi

# Linux sometimes does not have venv properly installed
if [ $(uname -s) == "Linux" ] ; then
    # Debian/Ubuntu
    sudo apt-get install python3-venv
fi


echo "Activating virtual environment..."
python3 -m venv kt_env
source kt_env/bin/activate

if type -p kotlin > /dev/null ; then
    echo "Kotlin already installed"
else
    # Installing kotlin with SDKMan
    read -p "Kotlin not found on the system. Would you like to install it with SDKMan (y/n): " kotlin_choice
    if [[ "$kotlin_choice" == "y" ]]; then
        curl -s "htpps://get.sdkman.io" | bash
        source "$HOME/.sdkman/bin/sdkman-init.sh"
        sdk install kotlin
        echo "*** Kotlin installed succesfully! ***"
    else
        echo "Kotlin installation skipped"
        echo "** Note that the following package installations may fail because of missing kotlin installation on the system! **"
    fi
fi

# installing kotlin jupyter dependencies
echo "Installing kotlin notebook dependencies..."
pip install jupyter kotlin-jupyter-kernel

echo "Deactivating virtual environment..."
deactivate 

echo "*** Kotlin dependencies installed succesfully! ***"
echo "Remember to activate the virtual environment with:"
echo "\$ source kt_env/bin/activate"
