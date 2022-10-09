import time

import grequests
import requests

SERVLET_URL = r"http://localhost:8080/Laborator1-1.0-SNAPSHOT/lab1-servlet"


def invoke_servlet(url):
    return requests.get(url=url).text


def invoke_servlet_multi_threading(url, calls_count):
    url_list = [url for _ in range(calls_count)]
    res = (grequests.get(u) for u in url_list)
    return grequests.map(res)


if __name__ == "__main__":
    word = "anaare"
    size = 0
    # print(invoke_servlet(url=SERVLET_URL + f"?word={word}" + f"&size={size}"))
    for calls_count in [10, 50, 100, 500, 1000]:
        start = time.perf_counter()
        results = invoke_servlet_multi_threading(url=SERVLET_URL + f"?word={word}" + f"&size={size}",
                                                 calls_count=calls_count)
        stop = time.perf_counter()
        successful_calls = list(map(lambda response: response.status_code == 200, results)).count(True)
        print(
            f"For {calls_count} async calls: Duration = {stop - start} s, Successful requests = {successful_calls}, Failed requests = {len(results) - successful_calls}")
