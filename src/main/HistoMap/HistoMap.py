def main():
    data = open("alice30.txt")
    lines = data.read().split()
    count = {}

    for word in lines:
        word = word.lower()
        count[word] = count.get(word, 0) + 1

    keyList = sorted(count.keys())

    for k in keyList:
        print(f"{k} occurred {count[k]} times")

main()