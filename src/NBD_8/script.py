import requests

BASE_URL = 'http://localhost:8098'
BUCKET = 's15045'
URL = f'{BASE_URL}/buckets/{BUCKET}'


def main():
    key = 'witcher'
    witcher = {'name': 'Witcher 3', 'price': 160, 'has_dlc': True}

    result_insert = insert_or_update(key, witcher)
    print(f'Inserted value: {witcher} with key: "{key}". Response code: {result_insert}')
    result_get = get(key)
    print(f'Fetched document: {result_get["result"]}. Response code: {result_get["code"]}\n')

    witcher['price'] = 220
    result_update = insert_or_update(key, witcher)
    print(f'Updated value: {witcher} with key: "{key}". Response code: {result_update}')
    result_get_updated = get(key)
    print(f'Fetched updated document: {result_get_updated["result"]}. Response code: {result_get_updated["code"]}\n')

    result_delete = delete(key)
    print(f'Deleted by key: "{key}". Response code: {result_delete}')
    result_get_deleted = get(key)
    print(f'Fetched deleted document: {result_get_deleted["result"]}. Response code: {result_get_deleted["code"]}')


def get(key):
    req = requests.get(f'{URL}/keys/{key}')
    try:
        json_result = req.json()
    except ValueError:
        json_result = None
    return {'code': req.status_code, 'result': json_result}


def insert_or_update(key, value):
    req = requests.put(f'{URL}/keys/{key}', json=value)
    return req.status_code


def delete(key):
    req = requests.delete(f'{URL}/keys/{key}')
    return req.status_code


if __name__ == '__main__':
    main()
