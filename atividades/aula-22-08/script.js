let randomTarget = Math.round(Math.random(10) * 100)
let guessCount = 0;
let bets = []

function calculateHintLimits(bet) {
    let topLimit
    let bottomLimit
    if (bet > randomTarget) {
        topLimit = bet
        bottomLimit = randomTarget - (bet - randomTarget)
        if (bottomLimit < 0) {
            bottomLimit = 0
        }
    } else {
        bottomLimit = bet
        topLimit = randomTarget + (randomTarget - bet)
        if (topLimit > 100) {
            topLimit = 100
        }
    }
    return [bottomLimit, topLimit]
}

function handleSubmit(e) {
    e.preventDefault()
    let inputDoc = document.getElementById("bet-number")
    let betListDoc = document.getElementById("bet-list")
    let hintDoc = document.getElementById("hint")

    let resultGifDoc = document.getElementById("result-gif")
    let resultTextDoc = document.getElementById("result-text")



    let bet = Number(inputDoc.value)

    if (!bets.includes(bet)) {
        guessCount++;
        bets.push(bet)
        betListDoc.innerHTML = bets.length > 0 ? "Histórico de tentativas: " + bets.reduce((prev, cur, idx, arr) => {
            if (idx === 0) {
                return cur
            } else {
                return prev + ", " + cur
            }
        }, "") : ""
    }


    function reset() {
        randomTarget = Math.round(Math.random() * 100)
        guessCount = 0
        bets = []
        hintDoc.setAttribute("hidden", true)
        resultGifDoc.setAttribute("hidden", true)
        resultTextDoc.setAttribute("hidden", true)
        inputDoc.removeAttribute("disabled")
        document.getElementById("submit").removeAttribute("disabled")
        betListDoc.innerHTML = ""
    }

    function showResult(success) {
        let gifSource;
        let textContent;
        if (success) {
            gifSource = "https://gizmodo.uol.com.br/wp-content/blogs.dir/8/files/2021/02/nyan-cat-1.gif"
            textContent = "Você ganhou!"

        } else {
            gifSource = "https://media.tenor.com/5aF7np_zPEgAAAAd/pepe-why-pepe-the-frog.gif"
            textContent = "GAME OVER! O numero aleatório é " + randomTarget
        }
        resultGifDoc.setAttribute("src", gifSource)
        resultTextDoc.innerHTML = textContent
        resultGifDoc.removeAttribute("hidden")
        resultTextDoc.removeAttribute("hidden")
        inputDoc.setAttribute("disabled", true)
        document.getElementById("submit").setAttribute("disabled", true)
        hintDoc.setAttribute("hidden", true)

        setTimeout(() => {
            reset()
        }, 5000)
    }

    const [bottomLimit, topLimit] = calculateHintLimits(bet)
    let hint = `O seu valor esta entre ${bottomLimit} e ${topLimit}`

    if (bet > randomTarget) {
        hintDoc.removeAttribute("hidden")
        hintDoc.textContent = hint
    } else if (bet < randomTarget) {
        hintDoc.removeAttribute("hidden")
        hintDoc.textContent = hint
    } else {
        showResult(true)
    }

    if (guessCount === 5) {
        showResult(false)
    }

    inputDoc.value = ""
    inputDoc.focus()
}




document.getElementById("form").addEventListener("submit", handleSubmit)