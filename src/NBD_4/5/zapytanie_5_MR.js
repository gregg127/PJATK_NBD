db.people.mapReduce(
    function () {
        for (let card in this.credit) {
            emit(this.credit[card].currency,
                {
                    balance: this.credit[card].balance,
                    counter: 1
                }
            );
        }
    },
    function (key, values) {
        let reduced = {
            balance_sum: 0,
            counter: 0
        };
        values.forEach(e => {
            reduced.balance_sum += e.balance;
            reduced.counter += e.counter;
        });
        return reduced;
    },
    {
        out: "polishBalanceEachCurrencyFemale",
        query: {
            nationality: "Poland",
            sex: "Female"
        },
        finalize: function (key, values) {
            return {
                avg_balance: values.balance_sum / values.counter,
                total_balance: values.balance_sum
            }
        }
    }
);
printjson(db.polishBalanceEachCurrencyFemale.find().toArray());