db.people.mapReduce(
    function () {
        for (let card in this.credit) {
            emit(
                this.credit[card].currency,
                this.credit[card].balance
            );
        }
    },
    function (key, values) {
        return Array.sum(values);
    },
    {
        out: "sumBalanceEachCurrency"
    }
);
printjson(db.sumBalanceEachCurrency.find().toArray());