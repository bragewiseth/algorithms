def binersok(n, x):
    hoy = len(n)-1
    lav = 0
    i = 0
    while lav <= hoy :
        i = int((hoy + lav) / 2)
        if n[i] < x :
            lav = i + 1
        elif n[i] > x :
            hoy = i - 1
        elif n[i] == x :
            return i
    return None

if __name__ == "__main__" :
    x = 6
    n = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40]
    print(binersok(n, x))
