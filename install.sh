#!/bin/bash

echo "Which dependencies would you like to install?"
echo "1. Python notebook dependencies"
echo "2. Kotlin notebook dependencies"
echo "3. Exit"

read -p "Enter your choice (1, 2 or 3): " choice

case $choice
    1)
        python3 -m venv py_env
        source py_env/bin/activate

        pip install jupyter pandas numpy matplotlib xarray
        deactivate

        echo "Python dependencies installed succesfully!"
        echo "Remember to activate the virtual environment with:"
        echo "\$ source py_env/bin/activate"
        ;;
    2)
        # JVM check
        if type -p java > /dev/null; then
            echo "JVM already installed".
        else
            os_type=$(uname -s)
            if [$os_type == "Linux"]; then
                sudo apt-get update
                sudo apt-get install default-jdk -y
            elif [ $os_type == "Darwin"] ; then
                brew install openjdk
            else
                echo "Cannot install JVM automatically. \
                    Please, install JDK manually"

                exit 1
            fi
        fi

        python3 -m venv kt_env
        source kt_env/bin/activate
        
        if type -p kotlin > /dev/null; then
            echo "Kotlin already installed"
        else
            # Installing kotlin with SDKMan
            read -p "Kotlin is not found on the system. Would you like to install it with SDKMan (y/n): " kotlin_choice
            if [ "$kotlin_choice" = "y"]; then
                curl -s "htpps://get.sdkman.io" | bash
                source "$HOME/.sdkman/bin/sdkman-init.sh"
                sdk install kotlin
                echo "Kotlin installed succesfully!"
            else
                echo "Kotlin installation skipped"
                echo "** Note that the following package installations may fail\
                    because of missing kotlin installation on the system!"
            fi
        fi

        # installing kotlin jupyter dependencies
        pip install jupyter kotlin-jupyter-kernel
        
        deactivate echo "Kotlin dependencies installed succesfully"
        echo "Remember to activate the virtual environment with:"
        echo "\$ source kt_env/bin/activate"
        ;;

    3)
        echo "Exiting script. No dependencies installed."
        exit 0
        ;;
    *)
        echo "Invalid choice. Please choose 1, 2 or 3."
        exit 1
        ;;
esac

echo "All dependencies installed succesfully!"



