import os


# command = 'javap -p org.sbml.jsbml.CompartmentalizedSBase'

def print_output(output):
    for line in output:
        print(line)

def clean_line(data):
    temp = []
    for i in data:
        if i !='':
            temp.append(i)
    return temp

def parse_output(output):
    output_data = {}
    for line in output:
        #print(line) 
        data_stage1 = line.split('\n')
        # print(data_stage1)       
        data_stage2 = data_stage1[0].split(' ')
        temp_data = clean_line(data_stage2)
        print(temp_data)
        

        function_name_step1  = temp_data[-1].split(');')
        function_name_step2  = function_name_step1[0].split('(')
        function_name = function_name_step2[0] 
        print('function_name ',function_name)
        if '{' in temp_data:
            output_data.update({'classInfo':temp_data[:-1]})
        elif function_name in temp_data:
            output_data.update({'methods':temp_data})
    return output_data

def get_class_information(class_name=None):
    command = 'javap -package {0}'.format(class_name)
    class_output  = os.popen('{0}'.format(command)).readlines()
    # print_output(class_output)
    dict_data = parse_output(class_output)
    print(dict_data)




# get_class_information()

# class_name = 'org.sbml.jsbml.CompartmentalizedSBase'

class_name = 'org.sbml.jsbml.AbstractNamedSBase'
get_class_information(class_name)