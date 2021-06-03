printjson(db.people.aggregate([{
    "$group": {
        "_id": {"sex": "$sex"},
        "avg_weight": {"$avg": "$weight"},
        "avg_height": {"$avg": "$height"}
    }
}]).toArray());