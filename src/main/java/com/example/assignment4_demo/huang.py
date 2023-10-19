#Name: Bryant Huang
#Assignment: Assignment 6
import sys
import mysql.connector as mysql
import csi3335 #is a dictionary with the keys 'location', 'user', 'password', and 'database'
def main():
    # Parse command line arguments
    if len(sys.argv) != 3:
        print("Usage: python huang1.py <team name> <year>")
        sys.exit(1)
    team_name = sys.argv[1]
    year = sys.argv[2]
    conn = mysql.connect(host=csi3335.mysql['location'], user=csi3335.mysql['user'], password=csi3335.mysql['password'], database=csi3335.mysql['database'])
    cursor = conn.cursor()
    # Query database for team name and year
    #A list of all of the players names (first and last names) follows in normal text, one per line.
    stmt = "SELECT COUNT(*) FROM batting b NATURAL JOIN people p WHERE teamid = %s AND yearid = %s"
    cursor.execute(stmt, (team_name, year))
    cnt = cursor.fetchone()
    num = cnt[0]
    stmt = "SELECT CONCAT(namefirst, ' ', namelast) AS name FROM batting b NATURAL JOIN people p WHERE teamid = %s AND yearid = %s GROUP BY name"
    cursor.execute(stmt, (team_name, year))
    result = cursor.fetchall()
    # Check if query returned any results
    if result == 0:
        print("Error: team name did not play in that year")
        sys.exit(1)
    result_list = [row[0] for row in result]
    # Write results to HTML file
    with open('huang.html', 'w') as html_file:
        html_file.write('<html><h1 style="text-align:center">Data Display</h1></head><body>\n')
        html_file.write('<h2 style="text-align:center">Data from Database</h2>\n')
        html_file.write('<h2 style="text-align:center">Number of players</h2>\n')
        html_file.write(f'<h2 style="text-align:center">{num}</h2>\n')
        html_file.write('<ul>\n')
        for item in result_list:
            if item == None:
                html_file.write(f'<li>None</li>\n')
            else:
                html_file.write(f'<li>{item}</li>\n')
        html_file.write('</ul>\n')
        html_file.write('</body></html>\n')
    # Close database connection
    conn.close()
if __name__ == "__main__":
    main()