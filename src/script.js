function AllValidIps(stringRecebida, indice, contador, IP) {

    if (stringRecebida.length == indice && contador == 4) {
        console.log(IP)
        return
    }

    if (stringRecebida.length < indice + 1) {
        return
    }

    for (let index = 0; index < 3; index++) {
        if (index == 1) {
            if (stringRecebida.length < indice + 2 || (stringRecebida.charAt(indice) == 0)) {
                return
            }
        }

        if (index == 2) {
            if (stringRecebida.length < indice + 3 || parseInt(stringRecebida.slice(indice, indice + 3)) > 255) {
                
                return
            }

        }

        IP += stringRecebida.slice(indice, indice + index+1) + ".";
        AllValidIps(stringRecebida, indice+ 1, contador + 1, IP)
        IP = IP.slice(0, IP.length-index+2)
        

    }
}

AllValidIps("25503567", 0, 0, "")
