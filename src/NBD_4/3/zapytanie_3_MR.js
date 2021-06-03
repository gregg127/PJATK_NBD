db.people.mapReduce(
    function () {
        emit(this.job, 0);
    },
    function (key, value) {
        return key;
    },
    {
        out: "distinctJobs"
    }
);
printjson(db.distinctJobs.find().toArray());