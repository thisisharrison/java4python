class Fraction:
    def __init__(self, num, den):
        g = gcd(num, den)
        self.num = num / g
        self.den = den / g

    def __str__(self):
        return f"{self.num}/{self.den}"

    def add(self, fraction):
        return Fraction(fraction.den * self.num + self.den * fraction.num, self.den * fraction.den)

    # operator overloading, can use `+` directly
    def __add__(self, fraction):
        return Fraction(fraction.den * self.num + self.den * fraction.num, self.den * fraction.den)

    def unary(self):
        return Fraction(-self.num, self.den)

    def subtract(self, fraction):
        return self.add(self.unary())


def gcd(num1, num2):
    if num2 == 0:
        return num1
    else:
        return gcd(num2, num1 % num2)


one_half = Fraction(1, 2)
one_third = Fraction(1, 3)

x = one_half.add(one_third)
print(x)

x = one_half + one_third
print(x)