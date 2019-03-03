def do_work(input_list):
    n = len(input_list)
    print(round(sum(input_list) / n))
    print(sorted(input_list)[round(n / 2)])
    print(count_num(input_list))
    print(max(input_list) - min(input_list))


def count_num(input_list):
    counter_list = []
    for item in input_list:
        counter_list.append(input_list.count(item))
    return input_list[counter_list.index(max(counter_list))]
