function AllValidIps(stringRecebida, indice, contador, IP) {
    if (stringRecebida.length == indice && contador == 4) {
        document.getElementById("root").innerHTML += "<h1>"+IP.substring(0, IP.length - 1)+"</h1>"
        return
    }
    if (stringRecebida.length < indice + 1) {
        document.getElementById("trace").innerHTML += "<h2>Fim da stringRecebida, sem resultado. Bora Voltar!</h2>"
        return
    }
    for (let index = 0; index < 3; index++) {
        if (index == 1) {
            if (stringRecebida.length < indice + 2 || (stringRecebida.charAt(indice) == 0)) {
                return
            }
        }
        if (index == 2) {
            if (stringRecebida.length < indice + 3 || parseInt(stringRecebida.substring(indice, indice+3)) > 255) {
                return
            }
        }
        IP += stringRecebida.substring(indice, indice + index + 1) + ".";
        document.getElementById("trace").innerHTML += "<h1>"+IP+"</h1>"
        AllValidIps(stringRecebida, indice + index + 1, contador + 1, IP)
        IP = IP.substring(0, IP.length - (2 + index))
        document.getElementById("trace").innerHTML += "<h1>"+IP+" Bactrack!"+"</h1>"
    }
}



//24696532
//25503567
//257256897
//234532110
//00221121