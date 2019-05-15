# Factory Pattern Kata
This is a simple and short kata created to understand how the Factory design pattern works, how it can be used, and to
learn when you can apply it and its impact in your code.

This repository contains a very simple code that implements a small part of a license activation system. There are two
types of licenses:
* With hardware check: The hardware identifier of the device is taken into account, and the maximum number of active
devices is limited. If the requested device is already active, the license is granted again and the activation count
is not incremented
* Without hardware check: The hardware identifier of the device is not taken into account and the number of active
devices is unlimited.

For both license types the expiration date is checked.

## Instructions
You must refactor the LicenseManager class (in particular the check_activation method) to make use of the Factory
Pattern. Basic tests are provided to help you understand the functionality and to help you check if your code is still
working. You should not need to modify the provided tests (you can add new ones if you want/need to).

## Solution
There are many valid solutions. You can find an example in the development branch.