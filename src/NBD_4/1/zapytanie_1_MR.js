db.people.mapReduce(
    function () {
        emit(this.sex,
            {
                weight: this.weight,
                height: this.height,
                counter: 1
            }
        );
    },
    function (key, values) {
        let reduced = {
            sum_weight: 0,
            sum_height: 0,
            counter: 0
        };
        values.forEach(e => {
            reduced.sum_weight += e.weight;
            reduced.sum_height += e.height;
            reduced.counter += e.counter;
        });
        return reduced;
    },
    {
        out: "averageWeightHeightEachSex",
        finalize: function (key, values) {
            return {
                avg_weight: values.sum_weight / values.counter,
                avg_height: values.sum_height / values.counter
            }
        }
    }
);
printjson(db.averageWeightHeightEachSex.find().toArray());