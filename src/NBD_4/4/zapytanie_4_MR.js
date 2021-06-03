db.people.mapReduce(
    function () {
        let bmi = this.weight / Math.pow(this.height / 100, 2);
        emit(this.nationality, {
            bmi: bmi,
            bmi_min: 0,
            bmi_max: 0,
            counter: 1
        });
    },
    function (key, value) {
        let reduced = {
            bmi_sum: 0,
            bmi_min: value[0].bmi,
            bmi_max: 0,
            counter: 0
        };
        value.forEach(e => {
            if (reduced.bmi_min > e.bmi) {
                reduced.bmi_min = e.bmi;
            } else if (reduced.bmi_max < e.bmi) {
                reduced.bmi_max = e.bmi;
            }
            reduced.bmi_sum += e.bmi;
            reduced.counter += e.counter;
        });
        return reduced;
    },
    {
        out: 'bmiByNationality',
        finalize: function (key, values) {
            return {
                avg_bmi: values.bmi_sum / values.counter,
                min_bmi: values.bmi_min,
                max_bmi: values.bmi_max,
            }
        }
    }
);
printjson(db.bmiByNationality.find().toArray());